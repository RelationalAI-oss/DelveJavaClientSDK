{
  pkgs ? import <nixpkgs> {},
  delveBinary ? "",
  doCheck ? true
}:
with pkgs;
let
  mavenBuild = buildMaven ./project-info.json;
  build = lib.overrideDerivation mavenBuild.build (oldAttrs: {
    buildInputs = [ openjdk11 maven ];
    buildPhase = ''
      mvn --offline --settings ${mavenBuild.settings} compile
    '';
    installPhase = ''
      mkdir $out
      mvn --offline --settings ${mavenBuild.settings} package
      mv target/*.jar $out/
    '';
    checkPhase = ''
    # running delve server
      mvn --offline --settings ${mavenBuild.settings} test
    '';
    doCheck = false;
  });

in stdenv.mkDerivation rec {
  name = "java-client-sdk";
  version = "1.1.0";
  buildInputs = [ makeWrapper ];
  src = ./.;
  buildCommand = ''
    mkdir -p $out/{lib,bin}
    cp ${build}/*.jar $out/lib/
  '';
}
