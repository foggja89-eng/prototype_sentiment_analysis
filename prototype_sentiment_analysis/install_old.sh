# install.sh -- use this for installing programming languages and models. . 
# Note: this was designed for fedora. If your version of Linux uses apt instead of dnf for installation, just swap out dnf for apt on those lines. 
# Author: James C. Fogg
# Version: 2026.03.01

echo
echo '=====START OF INSTALL.SH====='
echo

# recommended installations from microsoft copilot
echo 'installing misc. development tools and dependencies.'
sudo dnf5 install @development-tools
sudo dnf install python3.12-devel
sudo dnf install cmake protobuf-devel abseil-cpp-devel

echo
echo 'installing java and related commands...'
echo
sudo dnf install java
sudo dnf install javac
echo
echo 'installing python...'
sudo dnf install python
echo
echo 'installing pip...'
sudo dnf install pip
echo
echo 'installing spaCy...'
pip install spacy
echo
echo 'installing spacy transformers...'
echo 
echo 'installing small english language model...'
python -m spacy download en_core_web_sm
echo
echo 'installing medium english language model...'
python -m spacy download en_core_web_md
echo
echo 'installing large english language model...'
python -m spacy download en_core_web_lg
echo
echo 'installing roBERTa based GPU model...'
python -m spacy download en_core_web_trf
echo
echo '=====END OF INSTALL.SH====='
echo
