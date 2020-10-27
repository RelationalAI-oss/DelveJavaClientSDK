{
  pkgs ? import <nixpkgs> {},
  delveBinary ? "",
  doCheck ? true
}:

with pkgs;
let
  mavenBuild = buildMaven ./project-info.json;
in
stdenv.mkDerivation rec {
  name = "delve-java-client-sdk-${version}";
  version = "1.1.0";
  src = ./.;

  buildInputs = [
    delveBinary
    maven
    openjdk11
  ];

  buildPhase = ''
    mvn --offline --settings ${mavenBuild.settings} compile
  '';

  installPhase = ''
    mkdir $out
    mvn --offline --settings ${mavenBuild.settings} package -Dmaven.test.skip=true
    cp -rv target/*.jar $out/
  '';

  checkPhase = ''
    mkdir home
    export HOME=$PWD/home

    delve server &
    PID=$!
    sleep 15s
    mvn --offline --settings ${mavenBuild.settings} test || (kill -9 $PID && exit 1)
    echo "Shutting down delve server. Pid: $PID"
    kill -9 $PID
  '';

  inherit doCheck;
}
