{
  pkgs ? import <nixpkgs> {},
  delveBinary ? "",
  doCheck ? true
}:

with pkgs;
let
  mavenBuild = buildMaven ./project-info.json;
in
lib.overrideDerivation mavenBuild.build (oldAttrs: {
  buildInputs = [ openjdk11 maven ];
  buildPhase = ''
    mvn --offline --settings ${mavenBuild.settings} compile
  '';
  installPhase = ''
    mkdir $out
    mvn --offline --settings ${mavenBuild.settings} package
    cp -rv target/*.jar $out/
  '';
  checkPhase = ''
    ${delveBinary}/bin/delve server &
    PID=$!
    sleep 15s
    mvn --offline --settings ${mavenBuild.settings} test || kill -9 $PID && exit -1
    kill -9 $PID
  '';
  doCheck = doCheck;
})
