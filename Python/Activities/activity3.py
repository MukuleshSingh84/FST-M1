user1=input("Enter your name: ")
user2=input("Enter your name: ")
User1Ans=input(user1+" choose 1 from rock, paper or scissors? ")
User2Ans=input(user2+" choose 1 from rock, paper or scissors? ")
if User1Ans==User2Ans:
    print("draw")
elif User1Ans=="rock":
    if User2Ans=="scissors":
        print(user1+" is winner")
    else:
        print(user2+" is winner")
elif User1Ans=="scissors":
    if User2Ans=="rock":
        print(user2+" is winner")
    else:
        print(user1+" is winner")
elif User1Ans=="paper":
    if User2Ans=="rock":
        print(user1+" is winner")
    else:
        print(user2+" is winner")
else:
    print("Incorrect input")

