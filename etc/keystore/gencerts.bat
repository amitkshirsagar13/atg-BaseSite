@Echo OFF

REM Create the DEV server keystore
REM The keystore and key passwords are developer
REM %JAVA_HOME%\bin\keytool.exe -genkey -alias localhost -keyalg RSA -keystore BaseSiteATG_dev.keystore -storepass developer -keypass developer -dname "CN=localhost, OU=SSL Certificate Inspector #5, O=Self-Signed Certificate Factory, L=Anytown, ST=Anystate, C=US"
REM %JAVA_HOME%\bin\keytool.exe -export -alias localhost -keystore BaseSiteATG_dev.keystore -storepass developer -file localhost.cer

REM You can also import and trust certs that you've D/L from remote servers using a browser
%JAVA_HOME%\bin\keytool.exe -import -v -keystore BaseSiteATG_dev.keystore -storepass developer -alias digicert_ss_ca_int -file digicert_ss_ca.cer -trustcacerts
%JAVA_HOME%\bin\keytool.exe -import -v -keystore BaseSiteATG_dev.keystore -storepass developer -alias hostname -file hostname.cer -trustcacerts

REM Create the STAGE server keystore
REM The keystore password is staging
%JAVA_HOME%\bin\keytool.exe -import -v -keystore BaseSiteATG_stage.keystore -storepass staging -alias digicert_ss_ca_int -file digicert_ss_ca.cer -trustcacerts
%JAVA_HOME%\bin\keytool.exe -import -v -keystore BaseSiteATG_stage.keystore -storepass staging -alias hostname -file hostname.cer -trustcacerts

REM Create the PROD server keystore
REM The keystore password is production
%JAVA_HOME%\bin\keytool.exe -import -v -keystore BaseSiteATG_prod.keystore -storepass production -alias digicert_ss_ca_int -file digicert_ss_ca.cer -trustcacerts
%JAVA_HOME%\bin\keytool.exe -import -v -keystore BaseSiteATG_prod.keystore -storepass production -alias hostname -file hostname.cer -trustcacerts
