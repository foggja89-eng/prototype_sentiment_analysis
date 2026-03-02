# full_sequence.sh -- use this for installing everything needed for this to run and also to run a test. 
# Basically a full test run from installation to experimental output. 
# Author: James C. Fogg
# Version: 2026.03.01

echo
echo '=====START OF FULL_SEQUENCE.SH====='
echo 
echo 'starting installation script...'
echo
chmod +x *.sh
./install.sh
echo
echo 'starting test script...'
echo
./test.sh
echo
echo 'done testing. here is the current directory and files--'
echo
pwd
echo
ls
echo
echo '=====END OF FULL_SEQUENCE.SH====='
echo
