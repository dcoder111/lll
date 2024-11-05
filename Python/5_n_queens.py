def n_queens(n):
    col = set()
    posDiag = set()  # (r+c)
    negDiag = set()  # (r-c)
    res = []

    # Initialize the board with "0"s
    board = [["0"] * n for _ in range(n)]
    
    def backtrack(r):
        if r == n:
            # Format each row as a string with space-separated values and store it
            copy = [" ".join(row) for row in board]
            res.append(copy)
            return

        for c in range(n):
            # Skip if column or diagonal already has a queen
            if c in col or (r + c) in posDiag or (r - c) in negDiag:
                continue

            # Place the queen
            col.add(c)
            posDiag.add(r + c)
            negDiag.add(r - c)
            board[r][c] = "Q"

            # Recurse to the next row
            backtrack(r + 1)

            # Remove the queen (backtrack)
            col.remove(c)
            posDiag.remove(r + c)
            negDiag.remove(r - c)
            board[r][c] = "0"

    # Start backtracking from the first row
    backtrack(0)
    
    # Print all solutions
    if res:
        print(f"Found {len(res)} solutions for {n}-Queens problem:\n")
    for sol in res:
        for row in sol:
            print(row)
        print()  # Print a blank line between solutions

if __name__ == "__main__":
    # Take user input for board size
    n = int(input("Enter the size of the chessboard (n): "))
    n_queens(n)


# Output
# Enter the size of the chessboard (n): 4
# Found 2 solutions for 4-Queens problem:

# 0 Q 0 0
# 0 0 0 Q
# Q 0 0 0
# 0 0 Q 0

# 0 0 Q 0
# Q 0 0 0
# 0 0 0 Q
# 0 Q 0 0

