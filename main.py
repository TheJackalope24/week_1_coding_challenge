
#returns number of steps
def colatz_conjecture(num:int)->int:
    steps = 0
    while(num != 1):
        if(num % 2 == 0):
            num = num/2
        else:
            num = 3*num + 1
        steps+=1

    return steps

#returns string of which takes less steps
def colatz_compare(a:int, b:int)->str:
    steps_a = colatz_conjecture(a)
    steps_b = colatz_conjecture(b)
    if(steps_a < steps_b):
        return("a")
    else:
        return("b")

a = int(input("Enter number a: "))
b = int(input("Enter number b: "))

print(colatz_compare(a,b))
