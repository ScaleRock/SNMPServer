{ pkgs ? import <nixpkgs> {} }:


pkgs.mkShell {
  buildInputs = [
    jdk21
    pkgs.gradle

  ];

  shellHook = ''
    export JAVA_HOME=${jdk21}
    export PATH="$JAVA_HOME/bin:$PATH"

    echo "Using JAVA_HOME=$JAVA_HOME"
    java -version || true
  '';
}
