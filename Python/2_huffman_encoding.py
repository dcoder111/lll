import heapq

# Creating Huffman tree node
class Node:
    def __init__(self, freq, symbol, left=None, right=None):
        self.freq = freq       # Frequency of symbol
        self.symbol = symbol   # Symbol name (character)
        self.left = left       # Left child
        self.right = right     # Right child
        self.huff = ''         # Direction of node in the tree (0 or 1)

    # Define less than for priority queue ordering
    def __lt__(self, nxt):
        return self.freq < nxt.freq

# Function to print Huffman codes
def print_nodes(node, val=''):
    new_val = val + str(node.huff)
    
    # Traverse the left and right children
    if node.left:
        print_nodes(node.left, new_val)
    if node.right:
        print_nodes(node.right, new_val)

    # Print symbol and code if it's a leaf node
    if not node.left and not node.right:
        print(f"{node.symbol} -> {new_val}")

if __name__ == "__main__":
    # Taking characters and frequencies as input from the user
    chars = input("Enter characters (comma separated): ").split(',')
    freq = list(map(int, input("Enter frequencies (comma separated): ").split(',')))

    if len(chars) != len(freq):
        print("Error: Number of characters and frequencies must be the same.")
    else:
        nodes = []
        
        # Convert characters and frequencies into Huffman tree nodes
        for i in range(len(chars)):
            heapq.heappush(nodes, Node(freq[i], chars[i]))

        # Build the Huffman Tree
        while len(nodes) > 1:
            left = heapq.heappop(nodes)
            right = heapq.heappop(nodes)

            left.huff = 0
            right.huff = 1
            
            # Create a new parent node combining the two smallest nodes
            new_node = Node(left.freq + right.freq, left.symbol + right.symbol, left, right)
            heapq.heappush(nodes, new_node)

        # Print the Huffman codes for each character
        print("\nHuffman Codes:")
        print_nodes(nodes[0])  # Root of Huffman Tree
        
        
# op:
# Enter characters (comma separated): B, C, A, D
# Enter frequencies (comma separated): 1, 6, 5, 3

# Huffman Codes:
#  C -> 0
# B -> 100
#  D -> 101
#  A -> 11
