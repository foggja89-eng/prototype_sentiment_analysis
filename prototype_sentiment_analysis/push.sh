# push.sh -- use this as a better way to push changes with more informative output. 
# IMPORTANT: this assumes that global credential configuration for GitHub has been set on this machine. 
# TODO: branch and commit message will need to be manually set. 
# Author: James C. Fogg
# Version: 2026.03.01

echo
echo '=====START OF PUSH.SH====='
echo
echo 'adding files...'
git add .
echo 'adding commit message...'
echo
git commit -m 'slightly modified java documentation to make ProcessBuilder more clear. ' # TODO: this will need to be manually updated every time.
echo
echo 'pushing changes...'
echo
git push origin transformer-experimentation #TODO: this will need to be set to the appropriate branch manually. 
echo
echo 'DONE. here is the current local directory and files--'
echo
pwd
echo
ls
echo
echo '=====END OF PUSH.SH====='
echo
