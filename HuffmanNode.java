import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

// Node class to represent each character and its frequency
class HuffmanNode {
    char ch;
    int freq;
    HuffmanNode left = null;
    HuffmanNode right = null;

    HuffmanNode(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
    }

    // Constructor for internal nodes
    HuffmanNode(int freq, HuffmanNode left, HuffmanNode right) {
        this.freq = freq;
        this.left = left;
        this.right = right;
    }
}

// Comparator to order nodes by frequency in ascending order
class HuffmanEncoding {

    // Function to generate Huffman codes for each character
    public static void generateCodes(HuffmanNode root, String code, Map<Character, String> huffmanCode) {
        if (root == null) return;

        // Leaf node - add the code to map
        if (root.left == null && root.right == null) {
            huffmanCode.put(root.ch, code);
        }

        // Traverse left subtree (adding '0')
        generateCodes(root.left, code + "0", huffmanCode);
        
        // Traverse right subtree (adding '1')
        generateCodes(root.right, code + "1", huffmanCode);
    }

    // Function to build the Huffman tree and encode the input text
    public static HuffmanNode buildHuffmanTree(Map<Character, Integer> freqMap) {
        PriorityQueue<HuffmanNode> pq = new PriorityQueue<>((a, b) -> a.freq - b.freq);

        // Create a leaf node for each character and add to priority queue
        for (var entry : freqMap.entrySet()) {
            pq.add(new HuffmanNode(entry.getKey(), entry.getValue()));
        }

        // Loop until there is only one node left in the priority queue
        while (pq.size() > 1) {
            // Remove two nodes with the lowest frequency
            HuffmanNode left = pq.poll();
            HuffmanNode right = pq.poll();

            // Create a new internal node with frequency equal to the sum of the two nodes
            int sum = left.freq + right.freq;
            pq.add(new HuffmanNode(sum, left, right));
        }

        // The remaining node is the root of the Huffman Tree
        return pq.poll();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text to encode: ");
        String text = scanner.nextLine();

        // Step 1: Calculate frequency of each character
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char ch : text.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        // Step 2: Build Huffman Tree
        HuffmanNode root = buildHuffmanTree(freqMap);

        // Step 3: Generate Huffman Codes
        Map<Character, String> huffmanCode = new HashMap<>();
        generateCodes(root, "", huffmanCode);

        // Print Huffman Codes
        System.out.println("Huffman Codes:");
        for (var entry : huffmanCode.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // Step 4: Encode the input text
        StringBuilder encodedText = new StringBuilder();
        for (char ch : text.toCharArray()) {
            encodedText.append(huffmanCode.get(ch));
        }

        System.out.println("Encoded Text: " + encodedText);

        // Decoding (Optional)
        System.out.println("Decoded Text: " + decodeHuffman(root, encodedText.toString()));
    }

    // Function to decode the encoded text
    public static String decodeHuffman(HuffmanNode root, String encodedText) {
        StringBuilder decodedText = new StringBuilder();
        HuffmanNode current = root;
        for (char bit : encodedText.toCharArray()) {
            current = (bit == '0') ? current.left : current.right;

            // Reached a leaf node
            if (current.left == null && current.right == null) {
                decodedText.append(current.ch);
                current = root; // Go back to root
            }
        }
        return decodedText.toString();
    }
}


// Enter text to encode: BCAD
// Huffman Codes:
// A: 00
// B: 11
// C: 10
// D: 01
// Encoded Text: 11100001
// Decoded Text: BCAD

// Time Complexity (TC)
// Building the Frequency Map: O(n), where n is the number of characters in the input text. Building the Huffman Tree: O(d * log(d)), where d is the number of unique characters. We use a priority queue to combine nodes, and each insertion/extraction takes O(log d). Generating Huffman Codes: O(d), as each character requires a traversal from the root to its leaf node. Encoding the Text: O(n), since we replace each character in the text with its Huffman code. Decoding the Text: O(n), as we traverse the Huffman Tree for each bit in the encoded text.
// Overall Time Complexity: O(n + d * log(d))

// Space Complexity (SC)
// Frequency Map: O(d), storing the frequency of each unique character. Priority Queue: O(d), storing d nodes. Huffman Tree: O(d), as each unique character creates one node in the tree. Huffman Code Map: O(d), to store the code for each character. Encoded Text: O(n), for storing the compressed output.
// Overall Space Complexity: O(d + n)
