# install.sh -- use this for installing all dependencies. 
# Had a lot of trouble trying to get this to work for python 3.12, since not all dependencies support 3.13.
# This was generated with the help of Microsoft Copilot based on what I had done for the old installation script, which can be found in install_old.sh
# Author: James C. Fogg
# Version: 2026.03.01


echo
echo '=====START OF INSTALL.SH====='
echo

# install java
echo 'installing java programming language and tools...'
sudo dnf install java
sudo dnf install javac

# Development tools needed for curated-tokenizers and sentencepiece
sudo dnf5 install -y @development-tools
sudo dnf5 install -y python3.12-devel cmake protobuf-devel abseil-cpp-devel

echo
echo 'Installing Python 3.12 and pip for Python 3.12...'
sudo dnf5 install -y python3.12 python3.12-pip

# If python3.12-pip is missing on your Fedora version, bootstrap pip manually:
echo 'boostrapping pip...'
python3.12 -m ensurepip --upgrade || true
curl -sS https://bootstrap.pypa.io/get-pip.py -o get-pip.py
python3.12 get-pip.py

echo
echo 'Upgrading pip inside Python 3.12...'
python3.12 -m pip install --upgrade pip setuptools wheel

echo
echo 'Installing spaCy into Python 3.12 only...'
python3.12 -m pip install spacy

echo
echo 'Installing spaCy models (Python 3.12 only)...'
echo
echo 'installing small english language model...'
python3.12 -m spacy download en_core_web_sm
echo
echo 'installing medium english language model...'
python3.12 -m spacy download en_core_web_md
echo
echo 'installing large english language model'
python3.12 -m spacy download en_core_web_lg
echo
echo 'installing roBERTa based transformer model...'
python3.12 -m spacy download en_core_web_trf

# TODO: add any additional installations that need to be done. 
echo
echo 'installing textblob...'
python3.12 -m pip install textblob
echo
echo 'installing sys...'
python3.12 -m pip install sys

echo
echo '=====END OF INSTALL.SH====='
echo
