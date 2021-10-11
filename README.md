# Radix_Sort
The Radix Sort algorithm sorts numbers digit by digit, from the last digit to the first digit.
First we find the maximum number of digits, n. 
Second we sort the numbers by their last digit, from 0 to 9. 
Third, we extract the smallest numbers(that were sorted in the previous step). 
After repeating the last 2 steps for n-1 times, the list is fully sorted.
LinkedList is used as a container for storing the numbers.
