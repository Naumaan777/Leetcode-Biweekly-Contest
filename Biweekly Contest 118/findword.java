// Find word containning character

class findword {
    // Method to find words containing a specific character
    public List<Integer> findWordsContaining(String[] words, char x) {
        // Create a new ArrayList to store the indices of the words
        List<Integer> result = new ArrayList<>();
        
        // Loop through each word in the array
        for (int i = 0; i < words.length; i++) {
            // Check if the current word contains the character
            if (words[i].indexOf(x) != -1) {
                // If it does, add the index of the word to the result list
                result.add(i);
            }
        }
        
        // Return the list of indices
        return result;
    }
}
