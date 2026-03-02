echo
echo 'formatting java files'
echo
astyle --mode=java *.java
echo
echo 'compiling java files'
echo
javac *.java
echo
echo 'starting test -- positive sentiment'
echo 
java Driver.java < test1.txt > positive_output.txt
echo 
echo 'starting test -- neutral sentiment'
echo 
java Driver.java < test2.txt > neutral_output.txt
echo 
echo 'starting test -- negative sentiment'
echo 
java Driver.java < test3.txt > negative_output.txt 
echo 
echo 'unifying the results in output.txt'
echo
echo 'positive test' > unified_output.txt
cat positive_output.txt >> unified_output.txt
echo ' ' >> unified_output.txt
echo 'neutral test ' >> unified_output.txt
cat neutral_output.txt >> unified_output.txt
echo ' ' >> unified_output.txt
echo 'negative test' >> unified_output.txt
cat negative_output.txt >> unified_output.txt
echo ' ' >> unified_output.txt 
echo 
echo 'testing complete! the individual files can be viewed as positive_output.txt, neutral_output.txt, and negative_output.txt. Or, you can view it all together in unified_output.txt'
echo 'here is what the sample output looks like--'
echo
cat unified_output.txt
echo
echo '=====END OF TEST.SH====='
echo
