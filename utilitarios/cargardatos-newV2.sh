#!/bin/bash
export APIHOST=http://192.168.100.228:10000

./batch/lectura-circutor.sh 192.168.102.181 2 1 #"192.168.102.181" "2" "1"
sleep 1
php /usr/src/modpoll/modbus-circutorcvmC10-V2.php "192.168.102.181" "2" "2"
sleep 1
php /usr/src/modpoll/modbus-circutorcvmC10-V2.php "192.168.102.181" "2" "3"
sh /usr/src/modpoll/checkequipo3.sh
sleep 2
php /usr/src/modpoll/modbus-circutorcvmC10-V2.php "192.168.102.182" "3" "1"
sleep 1
php /usr/src/modpoll/modbus-circutorcvmC10-V2.php "192.168.102.182" "3" "2"
sleep 1
php /usr/src/modpoll/modbus-circutorcvmC10-V2.php "192.168.102.182" "3" "4"
sh /usr/src/modpoll/checkequipo4.sh
sleep 1
php /usr/src/modpoll/modbus-circutorcvmC10-V2.php "192.168.102.183" "4" "1"
sleep 1
php /usr/src/modpoll/modbus-circutorcvmC10-V2.php "192.168.102.183" "4" "2"
sleep 1
php /usr/src/modpoll/modbus-circutorcvmC10-V2.php "192.168.102.183" "4" "3"
sh /usr/src/modpoll/checkequipo5.sh
sleep 1
php /usr/src/modpoll/modbus-circutorcvmC10-V2.php "192.168.102.184" "5" "1"
sh /usr/src/modpoll/checkequipo37.sh
sleep 1
php /usr/src/modpoll/modbus-schneiderPM710-V2.php "192.168.20.100" "37" "1"
sleep 1
php /usr/src/modpoll/modbus-schneiderPM710-V2.php "192.168.20.100" "37" "2"
sleep 1
php /usr/src/modpoll/modbus-schneiderPM710-V2.php "192.168.20.100" "37" "4"
sleep 1
php /usr/src/modpoll/modbus-schneiderPM710-V2.php "192.168.20.100" "37" "5"
sleep1
php /usr/src/modpoll/modbus-schneiderPM710-V2.php "192.168.20.100" "37" "6"
sleep1
php /usr/src/modpoll/modbus-schneiderPM710-V2.php "192.168.20.100" "37" "7"
sleep1
php /usr/src/modpoll/modbus-schneiderPM710-V2.php "192.168.20.100" "37" "8"
sleep1
php /usr/src/modpoll/modbus-schneiderPM710-V2.php "192.168.20.100" "37" "9"
sleep1
php /usr/src/modpoll/modbus-schneiderPM710-V2.php "192.168.20.100" "37" "10"
sleep1
php /usr/src/modpoll/modbus-schneiderPM710-V2.php "192.168.20.100" "37" "11"
sleep1
php /usr/src/modpoll/modbus-schneiderPM710-V2.php "192.168.20.100" "37" "12"
sleep1
php /usr/src/modpoll/modbus-schneiderPM710-V2.php "192.168.20.100" "37" "13"
sleep1
php /usr/src/modpoll/modbus-schneiderPM5300-new.php "192.168.20.100" "37" "14"
sleep1
php /usr/src/modpoll/modbus-schneiderPM5300-new.php "192.168.20.100" "37" "3"
sh /usr/src/modpoll/checkequipo6.sh
sleep1
php /usr/src/modpoll/modbus-circutorcvmC10-V2.php "192.168.102.186" "6" "1"
sleep 1
php /usr/src/modpoll/modbus-circutorcvmC10-V2.php "192.168.102.186" "6" "2"
sleep 1
php /usr/src/modpoll/modbus-circutorcvmC10-V2.php "192.168.102.186" "6" "3"
sleep 1
php /usr/src/modpoll/modbus-circutorcvmC10-V2.php "192.168.102.186" "6" "4"
sleep 1
php /usr/src/modpoll/modbus-circutorcvmC10-V2.php "192.168.102.186" "6" "5"
sleep 1
php /usr/src/modpoll/modbus-circutorcvmC10-V2.php "192.168.102.186" "6" "6"
sleep 1
php /usr/src/modpoll/modbus-circutorcvmC10-V2.php "192.168.102.186" "6" "7"
sleep 1
php /usr/src/modpoll/modbus-circutorcvmC10-V2.php "192.168.102.186" "6" "8"
sh /usr/src/modpoll/checkequipo7.sh
sleep 1
php /usr/src/modpoll/modbus-circutorcvmC10-V2.php "192.168.102.187" "7" "1"
sleep 1
php /usr/src/modpoll/modbus-circutorcvmC10-V2.php "192.168.102.187" "7" "2"
sh /usr/src/modpoll/checkequipo8.sh
sleep 1
php /usr/src/modpoll/modbus-circutorcvmC10-V2.php "192.168.102.188" "8" "3"
sleep 1
php /usr/src/modpoll/modbus-circutorcvmC10-V2.php "192.168.102.188" "8" "4"
sleep 1
php /usr/src/modpoll/modbus-circutorcvmC10-V2.php "192.168.102.188" "8" "5"
sh /usr/src/modpoll/checkequipo9.sh
sleep 1
php /usr/src/modpoll/modbus-circutorcvmC10-V2.php "192.168.102.189" "9" "1"
sleep 1
php /usr/src/modpoll/modbus-circutorcvmC10-V2.php "192.168.102.189" "9" "3"
sleep 1
php /usr/src/modpoll/modbus-circutorcvmC10-V2.php "192.168.102.189" "9" "4"
sleep 1
php /usr/src/modpoll/modbus-circutorcvmC10-V2.php "192.168.102.189" "9" "5"
sh /usr/src/modpoll/checkequipo11.sh
sleep 1
php /usr/src/modpoll/modbus-circutorcvmC10-V2.php "192.168.102.191" "11" "1"
sleep 1
php /usr/src/modpoll/modbus-circutorcvmC10-V2.php "192.168.102.191" "11" "2"
sleep 1
php /usr/src/modpoll/modbus-circutorcvmC10-V2.php "192.168.102.191" "11" "3"
sleep 1
php /usr/src/modpoll/modbus-circutorcvmC10-V2.php "192.168.102.191" "11" "4"
sleep 1
php /usr/src/modpoll/modbus-circutorcvmC10-V2.php "192.168.102.191" "11" "5"
sleep 1
php /usr/src/modpoll/modbus-circutorcvmC10-V2.php "192.168.102.191" "11" "6"
sleep 1
php /usr/src/modpoll/modbus-circutorcvmC10-V2.php "192.168.102.191" "11" "7"
sleep 1
php /usr/src/modpoll/modbus-circutorcvmC10-V2.php "192.168.102.191" "11" "8"
sleep 1
php /usr/src/modpoll/modbus-circutorcvmC10-V2.php "192.168.102.191" "11" "9"
sh /usr/src/modpoll/checkequipo12.sh
sleep 1
php /usr/src/modpoll/modbus-circutorcvmC10-V2.php "192.168.102.192" "12" "1"
sleep 1
php /usr/src/modpoll/modbus-circutorcvmC10-V2.php "192.168.102.192" "12" "2"
sh /usr/src/modpoll/checkequipo13.sh
sleep 1
php /usr/src/modpoll/modbus-circutorcvmC10-V2.php "192.168.102.193" "13" "1"
sh /usr/src/modpoll/checkequipo14.sh
sleep 1
php /usr/src/modpoll/modbus-circutorcvmC10-V2.php "192.168.102.194" "14" "1"
sleep 1
php /usr/src/modpoll/modbus-circutorcvmC10-V2.php "192.168.102.194" "14" "2"
sleep 1
php /usr/src/modpoll/modbus-circutorcvmC10-V2.php "192.168.102.194" "14" "3"
sh /usr/src/modpoll/checkequipo10.sh
sleep 1
php /usr/src/modpoll/modbus-schneiderPM5300-new.php "192.168.102.190" "10" "1"
sleep1
php /usr/src/modpoll/modbus-circutorcvmC10-V2.php "192.168.102.190" "10" "2"
sh /usr/src/modpoll/checkequipo38.sh
sleep1
php /usr/src/modpoll/modbus-schneiderPM710-V2.php "192.168.94.2" "38" "1"
sleep1
php /usr/src/modpoll/modbus-schneiderPM710-V2.php "192.168.94.2" "38" "2"
sleep1
php /usr/src/modpoll/modbus-schneiderPM710-V2.php "192.168.94.2" "38" "3"
sleep1
php /usr/src/modpoll/modbus-schneiderPM710-V2.php "192.168.94.2" "38" "4"
sleep1
php /usr/src/modpoll/modbus-schneiderPM710-V2.php "192.168.94.2" "38" "5"
sleep1
php /usr/src/modpoll/modbus-schneiderPM710-V2.php "192.168.94.2" "38" "6"
sleep1
php /usr/src/modpoll/modbus-schneiderPM710-V2.php "192.168.94.2" "38" "7"
sleep1
php /usr/src/modpoll/modbus-schneiderPM710-V2.php "192.168.94.2" "38" "8"
sleep1
php /usr/src/modpoll/modbus-schneiderPM710-V2.php "192.168.94.2" "38" "9"
sleep1
php /usr/src/modpoll/modbus-schneiderPM710-V2.php "192.168.94.2" "38" "10"
sleep1
php /usr/src/modpoll/modbus-schneiderPM710-V2.php "192.168.94.2" "38" "11"
sleep1
php /usr/src/modpoll/modbus-schneiderPM710-V2.php "192.168.94.2" "38" "12"
sleep1
php /usr/src/modpoll/modbus-schneiderPM5300-new.php "192.168.94.2" "38" "13"
sleep1
php /usr/src/modpoll/modbus-schneiderPM710-V2.php "192.168.94.2" "38" "14"
sh /usr/src/modpoll/checkequipo39.sh
sleep1
php /usr/src/modpoll/modbus-schneiderPM710-V2.php "192.168.94.3" "39" "1"
sleep1
php /usr/src/modpoll/modbus-schneiderPM710-V2.php "192.168.94.3" "39" "2"
sleep1
php /usr/src/modpoll/modbus-schneiderPM710-V2.php "192.168.94.3" "39" "3"
sleep1
php /usr/src/modpoll/modbus-schneiderPM710-V2.php "192.168.94.3" "39" "4"
sleep1
php /usr/src/modpoll/modbus-schneiderPM710-V2.php "192.168.94.3" "39" "5"
sleep1
php /usr/src/modpoll/modbus-schneiderPM710-V2.php "192.168.94.3" "39" "6"
sleep1
php /usr/src/modpoll/modbus-schneiderPM710-V2.php "192.168.94.3" "39" "7"
sleep1
php /usr/src/modpoll/modbus-schneiderPM710-V2.php "192.168.94.3" "39" "8"
sleep1
php /usr/src/modpoll/modbus-schneiderPM710-V2.php "192.168.94.3" "39" "9"
sleep1
php /usr/src/modpoll/modbus-schneiderPM710-V2.php "192.168.94.3" "39" "10"
sleep1
php /usr/src/modpoll/modbus-schneiderPM710-V2.php "192.168.94.3" "39" "11"
sleep1
php /usr/src/modpoll/modbus-schneiderPM710-V2.php "192.168.94.3" "39" "12"
sleep1
php /usr/src/modpoll/modbus-schneiderPM710-V2.php "192.168.94.3" "39" "13"
sh /usr/src/modpoll/checkequipo40.sh
sleep1
php /usr/src/modpoll/modbus-circutorcvmC10-V2.php "192.168.18.254" "40" "1"
sleep1
php /usr/src/modpoll/modbus-circutorcvmC10-V2.php "192.168.18.254" "40" "2"
sleep1
php /usr/src/modpoll/modbus-circutorcvmC10-V2.php "192.168.18.254" "40" "4"
sleep1
php /usr/src/modpoll/modbus-circutorcvmC10-V2.php "192.168.18.254" "40" "5"
sleep1
php /usr/src/modpoll/modbus-circutorcvmC10-V2.php "192.168.18.254" "40" "6"
sleep1
php /usr/src/modpoll/modbus-circutorcvmC10-V2.php "192.168.18.254" "40" "7"
sleep1
php /usr/src/modpoll/modbus-circutorcvmC10-V2.php "192.168.18.254" "40" "8"
sh /usr/src/modpoll/checkequipo15.sh
sleep1
php /usr/src/modpoll/modbus-circutorcvmC10-V2.php "192.168.170.201" "15" "1"
sleep1
php /usr/src/modpoll/modbus-circutorcvmC10-V2.php "192.168.170.201" "15" "2"
sh /usr/src/modpoll/checkequipo16.sh
sleep1
php /usr/src/modpoll/modbus-circutorcvmC10-V2.php "192.168.102.195" "16" "1"
sh /usr/src/modpoll/checkequipo17.sh
sleep1
php /usr/src/modpoll/modbus-circutorcvmC10-V2.php "192.168.102.196" "17" "1"
exit
