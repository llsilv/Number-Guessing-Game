import random

def main():
    random_number = random.randint(0,100)
    tries = [10, 5, 3]
    difficulty = ["easy", "medium", "hard"]

    print("welcome to the number guessing game!")

    input_user = 0
    guess = -1

    print("please select the difficulty:")
    
    while input_user not in [1, 2, 3]:
        print("1. Easy (10 guesses)\n2. Medium (5 guesses)\n3. Hard (3 chances)\n\nEnter your choice: ")

        try:
            input_user = int(input())
        except ValueError:
            print("please only write an integer between 1 and 3")
            continue
        
        if input_user not in [1,2,3]:
            print("please only write an integer between 1 and 3")

    print(f"you selected {difficulty[input_user - 1]} difficulty\n")

    attempts = tries[input_user - 1]

    while attempts > 0:
        if guess == random_number:
            print(f"congratulations! you guessed the correct answer with {attempts} guesses left")
            break
        
        print("please enter your guess: ")
        attempts -= 1
        
        try:
            guess = int(input())
        except ValueError:
            print("please only write integers")
            continue

        if guess == random_number:
            print(f"Congratulations! You guessed the correct answer with {attempts} guesses left")
            break
        else:
            if guess > random_number:
                print(f"Incorrect, my number is smaller. {attempts} guesses left.")
            else:
                print(f"Incorrect, my number is larger. {attempts} guesses left.")

    if guess != random_number:
        print(f"sorry you didnt guess the correct answer, was it was: {random_number}")

if __name__ == "__main__":
    main()