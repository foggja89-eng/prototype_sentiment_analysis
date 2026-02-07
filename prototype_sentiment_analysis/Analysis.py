# Analysis.py -- the main functionality of this whole project. This will run basic sentiment analysis on a project. 
# This will rely on the use of an external library to run the analysis, and the result will also be printed out by this class. 
# At Ashley's suggestion, this will use the spaCy library to do the bulk of the work. 
# Online research suggests using spacy for preprocessing and textBlob to get the actual sentiment. 
# Author: James C. Fogg
# version: 2026.02.06

import spacy, textblob, sys
from textblob import TextBlob

#load the model and the file path to work on. 
file_path = sys.argv[1]
nlp = spacy.load("en_core_web_sm")

# read the data out of the provided file. 
def read_file(file_path):
    with open(file_path, "r") as f:
        data = f.read()
    return data

# run the computations to determine the sentiment of the provided file. 
# currently, this returns both the polarity and subjectivity of the text. awaiting further guidance from teammates on this. 
def get_sentiment(text):
    #preprocess the text using the loaded spacy model and clean out ending and punctuation tokens. 
    sentiment = TextBlob(" ".join([token.text for token in nlp(text) if not token.is_stop and not token.is_punct])).sentiment
    return {"polarity" : sentiment.polarity, "subjectivity" : sentiment.subjectivity}

#put everyhthing together to read the file and run the sentiment analysis. 
print(get_sentiment(read_file(file_path)))