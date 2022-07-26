@rem
@rem Copyright 2015 the original author or authors.
@rem
@rem Licensed under the Apache License, Version 2.0 (the "License");
@rem you may not use this file except in compliance with the License.
@rem You may obtain a copy of the License at
@rem
@rem      https://www.apache.org/licenses/LICENSE-2.0
@rem
@rem Unless required by applicable law or agreed to in writing, software
@rem distributed under the License is distributed on an "AS IS" BASIS,
@rem WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
@rem See the License for the specific language governing permissions and
@rem limitations under the License.
@rem

@if "%DEBUG%" == "" @echo off
@rem ##########################################################################
@rem
@rem  untitled startup script for Windows
@rem
@rem ##########################################################################

@rem Set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" setlocal

set DIRNAME=%~dp0
if "%DIRNAME%" == "" set DIRNAME=.
set APP_BASE_NAME=%~n0
set APP_HOME=%DIRNAME%..

@rem Resolve any "." and ".." in APP_HOME to make it shorter.
for %%i in ("%APP_HOME%") do set APP_HOME=%%~fi

@rem Add default JVM options here. You can also use JAVA_OPTS and UNTITLED_OPTS to pass JVM options to this script.
set DEFAULT_JVM_OPTS=

@rem Find java.exe
if defined JAVA_HOME goto findJavaFromJavaHome

set JAVA_EXE=java.exe
%JAVA_EXE% -version >NUL 2>&1
if "%ERRORLEVEL%" == "0" goto execute

echo.
echo ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH.
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:findJavaFromJavaHome
set JAVA_HOME=%JAVA_HOME:"=%
set JAVA_EXE=%JAVA_HOME%/bin/java.exe

if exist "%JAVA_EXE%" goto execute

echo.
echo ERROR: JAVA_HOME is set to an invalid directory: %JAVA_HOME%
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:execute
@rem Setup the command line

set CLASSPATH=%APP_HOME%\lib\untitled-1.0-SNAPSHOT.jar;%APP_HOME%\lib\kotlin-stdlib-jdk8-1.6.21.jar;%APP_HOME%\lib\grpc-protobuf-1.15.1.jar;%APP_HOME%\lib\protobuf-java-3.6.1.jar;%APP_HOME%\lib\grpc-stub-1.15.1.jar;%APP_HOME%\lib\javax.annotation-api-1.3.1.jar;%APP_HOME%\lib\grpc-netty-shaded-1.48.0.jar;%APP_HOME%\lib\vertx-web-4.3.2.jar;%APP_HOME%\lib\vertx-web-client-4.3.2.1.jar;%APP_HOME%\lib\vertx-web-templ-thymeleaf-4.3.2.jar;%APP_HOME%\lib\vertx-web-common-4.3.2.jar;%APP_HOME%\lib\vertx-auth-common-4.3.2.jar;%APP_HOME%\lib\vertx-bridge-common-4.3.2.jar;%APP_HOME%\lib\vertx-uri-template-4.3.2.jar;%APP_HOME%\lib\vertx-core-4.3.2.jar;%APP_HOME%\lib\spring-boot-starter-web-2.7.1.jar;%APP_HOME%\lib\spring-webmvc-5.3.21.jar;%APP_HOME%\lib\spring-boot-starter-json-2.7.1.jar;%APP_HOME%\lib\spring-boot-starter-2.7.1.jar;%APP_HOME%\lib\spring-boot-autoconfigure-2.7.1.jar;%APP_HOME%\lib\spring-boot-2.7.1.jar;%APP_HOME%\lib\spring-context-5.3.21.jar;%APP_HOME%\lib\spring-aop-5.3.22.jar;%APP_HOME%\lib\spring-web-5.3.21.jar;%APP_HOME%\lib\spring-beans-5.3.22.jar;%APP_HOME%\lib\jackson-datatype-jdk8-2.13.3.jar;%APP_HOME%\lib\jackson-datatype-jsr310-2.13.3.jar;%APP_HOME%\lib\jackson-module-parameter-names-2.13.3.jar;%APP_HOME%\lib\jackson-databind-2.13.3.jar;%APP_HOME%\lib\jackson-annotations-2.13.3.jar;%APP_HOME%\lib\jackson-core-2.13.3.jar;%APP_HOME%\lib\jackson-module-kotlin-2.13.3.jar;%APP_HOME%\lib\kotlin-stdlib-jdk7-1.6.21.jar;%APP_HOME%\lib\kotlin-reflect-1.5.30.jar;%APP_HOME%\lib\kotlin-stdlib-1.6.21.jar;%APP_HOME%\lib\grpc-protobuf-lite-1.15.1.jar;%APP_HOME%\lib\grpc-core-1.48.0.jar;%APP_HOME%\lib\grpc-api-1.48.0.jar;%APP_HOME%\lib\guava-31.1-android.jar;%APP_HOME%\lib\proto-google-common-protos-1.0.0.jar;%APP_HOME%\lib\error_prone_annotations-2.14.0.jar;%APP_HOME%\lib\perfmark-api-0.25.0.jar;%APP_HOME%\lib\netty-handler-proxy-4.1.78.Final.jar;%APP_HOME%\lib\netty-codec-http2-4.1.78.Final.jar;%APP_HOME%\lib\netty-codec-http-4.1.78.Final.jar;%APP_HOME%\lib\netty-resolver-dns-4.1.78.Final.jar;%APP_HOME%\lib\netty-handler-4.1.78.Final.jar;%APP_HOME%\lib\netty-transport-native-unix-common-4.1.78.Final.jar;%APP_HOME%\lib\netty-codec-socks-4.1.78.Final.jar;%APP_HOME%\lib\netty-codec-dns-4.1.78.Final.jar;%APP_HOME%\lib\netty-codec-4.1.78.Final.jar;%APP_HOME%\lib\netty-transport-4.1.78.Final.jar;%APP_HOME%\lib\netty-buffer-4.1.78.Final.jar;%APP_HOME%\lib\netty-resolver-4.1.78.Final.jar;%APP_HOME%\lib\netty-common-4.1.78.Final.jar;%APP_HOME%\lib\spring-boot-starter-tomcat-2.7.1.jar;%APP_HOME%\lib\spring-expression-5.3.21.jar;%APP_HOME%\lib\spring-core-5.3.22.jar;%APP_HOME%\lib\thymeleaf-3.0.15.RELEASE.jar;%APP_HOME%\lib\ognl-3.1.26.jar;%APP_HOME%\lib\javassist-3.21.0-GA.jar;%APP_HOME%\lib\spring-boot-starter-logging-2.7.1.jar;%APP_HOME%\lib\logback-classic-1.2.11.jar;%APP_HOME%\lib\log4j-to-slf4j-2.17.2.jar;%APP_HOME%\lib\jul-to-slf4j-1.7.36.jar;%APP_HOME%\lib\slf4j-api-1.7.36.jar;%APP_HOME%\lib\kotlin-stdlib-common-1.6.21.jar;%APP_HOME%\lib\annotations-13.0.jar;%APP_HOME%\lib\failureaccess-1.0.1.jar;%APP_HOME%\lib\listenablefuture-9999.0-empty-to-avoid-conflict-with-guava.jar;%APP_HOME%\lib\jsr305-3.0.2.jar;%APP_HOME%\lib\checker-qual-3.12.0.jar;%APP_HOME%\lib\j2objc-annotations-1.3.jar;%APP_HOME%\lib\gson-2.9.0.jar;%APP_HOME%\lib\annotations-4.1.1.4.jar;%APP_HOME%\lib\animal-sniffer-annotations-1.21.jar;%APP_HOME%\lib\jakarta.annotation-api-1.3.5.jar;%APP_HOME%\lib\snakeyaml-1.30.jar;%APP_HOME%\lib\tomcat-embed-websocket-9.0.64.jar;%APP_HOME%\lib\tomcat-embed-core-9.0.64.jar;%APP_HOME%\lib\tomcat-embed-el-9.0.64.jar;%APP_HOME%\lib\spring-jcl-5.3.22.jar;%APP_HOME%\lib\attoparser-2.0.5.RELEASE.jar;%APP_HOME%\lib\unbescape-1.1.6.RELEASE.jar;%APP_HOME%\lib\grpc-context-1.48.0.jar;%APP_HOME%\lib\logback-core-1.2.11.jar;%APP_HOME%\lib\log4j-api-2.17.2.jar


@rem Execute untitled
"%JAVA_EXE%" %DEFAULT_JVM_OPTS% %JAVA_OPTS% %UNTITLED_OPTS%  -classpath "%CLASSPATH%" MainKt %*

:end
@rem End local scope for the variables with windows NT shell
if "%ERRORLEVEL%"=="0" goto mainEnd

:fail
rem Set variable UNTITLED_EXIT_CONSOLE if you need the _script_ return code instead of
rem the _cmd.exe /c_ return code!
if  not "" == "%UNTITLED_EXIT_CONSOLE%" exit 1
exit /b 1

:mainEnd
if "%OS%"=="Windows_NT" endlocal

:omega
