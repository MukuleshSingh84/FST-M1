# print if the number entered is even or odd
num = int(input("Enter a Number"))
print(type(num))
num2=num%2
print(num2)
if num2>0:
    print("odd number")
else:
    print("even number")