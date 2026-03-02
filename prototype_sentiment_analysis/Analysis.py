# Analysis.py -- the main functionality of this whole project. This will run basic sentiment analysis on a project. 
# This will rely on the use of an external library to run the analysis, and the result will also be printed out by this class. 
# At Ashley's suggestion, this will use the spaCy library to do the bulk of the work. 
# Online research suggests using spacy for preprocessing and textBlob to get the actual sentiment. 
# IMPORTANT NOTE: the latest version of python that spaCy can work with is 3.12. 
# Author: James C. Fogg
# version: 2026.03.01

import spacy, textblob, sys
from textblob import TextBlob

# load the model and the file path to work on.
# you'll have to make sure each list is the same length. Did this so it's easy to work with later on. 
file_path       = sys.argv[1]
pipelines       = ["en_core_web_sm", "en_core_web_md", "en_core_web_lg", "en_core_web_trf"]
size_descriptor = ["small", "medium", "large", "large"]
description     = ["English language cpu-based model","English language cpu-based model", "English language cpu-based model", 
                "roBERTa based model that best runs on the GPU"]

# read the data out of the provided file. 
def read_file(file_path):
    with open(file_path, "r") as f:
        data = f.read()
    return data

# run the computations to determine the sentiment of the provided file. 
# this uses the en_core_web_sm transformer. 
# currently, this returns both the polarity and subjectivity of the text. awaiting further guidance from teammates on this. 
def get_sentiment(text):
    # cycle through each possible model for spaCy. Process the text using TextBlob to grab all tokens from it, run it through the model, grab the sentiment. 
    for i in range(len(pipelines)):
        print("\nDetermining sentiment using " + pipelines[i] + ": a " + size_descriptor[i] + " " + description[i] + "...")
        # grab each token and join them together in a list, provided that it is not punctuation or a stop token. Then determine the sentiment.
        sentiment = TextBlob(" ".join([token.text for token in spacy.load(pipelines[i])(text) if not token.is_stop and not token.is_punct])).sentiment
        #print the results for the polarity score and the subjectivity score. 
        print("Sentiment polarity score:", sentiment.polarity, "\nSentiment subjectivity score:", sentiment.subjectivity)

    #print("Grabbing sentiment using en_core_web_sm transformer on spaCy...")
    # process the text using the en_core_web_sm transformer. Grab the full sentiment, polarity, subjectivity...
    #sentiment = TextBlob(" ".join([token.text for token in spacy.load("en_core_web_sm")(text) if not token.is_stop and not token.is_punct])).sentiment
    #print("Done!\nSentiment polarity score: ", sentiment.polarity, "\nSentiment subjectivity score: ", sentiment.subjectivity)

#put everyhthing together to read the file and run the sentiment analysis. 
#the return value here is just for the calling program. 0 for failure, 1 for success. 
#<param> file_path, pathway for the text file to be analyzed. 
#<param> 
def get_sentiment_all(file_path):
    print("\n=====START OF ANALYSIS.PY=====")

    try:
        print("\nStarting sentiment analysis on the provided file using spaCy...")
        print(get_sentiment(read_file(file_path)))
        print("\nFinsihed sentiment analysis on provided file.")
        return 1
    except:
        print("\nSomething went wrong.")
        return 0
    finally:
        print("\n=====END OF ANALYSIS.PY=====\n")

# run this entire program. 
get_sentiment_all(file_path)