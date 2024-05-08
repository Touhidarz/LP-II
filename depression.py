print("\033[0;32m\033[1mWelcome to Depression Level Prediction System!")

def print_options():
    print("\t(1) Not at all")
    print("\t(2) Several Days")
    print("\t(3) More than half the days")
    print("\t(4) Nearly everyday")

question_list =["Little interest or pleasure in doing things",
                "Feeling down, depressed, or hopeless",
                "Trouble falling or staying asleep, or sleeping too much",
                "Feeling tired or having little energy",
                "Poor appetite or overeating",
                "Feeling bad about yourself or that you are a failure or have let yourself or your family down",
                "Trouble concentrating on things, such as reading the newspaper or watching television",
                "Moving or speaking so slowly that other people could have noticed. Or the opposite being so figety or restless that you have been moving around a lot more than usual",
                "Thoughts that you would be better off dead, or of hurting yourself"
                ]
score = 0

def accept_ans():
    flag = True
    while (flag):
        ans = int(input("Your choice: "))
        if(ans == 1 or ans==2 or ans == 3 or ans ==4):
            flag = False
            # print(ans-1)
            return (ans-1)
        else:
            print("\033[0;31mEnter a valid option!\033[1;37m")
 
def find_results(score):
    print("\n\033[4mSCORE: ", score)
    print("Depression severity: ", end="")
    if(score in range(1,5)):
        print("Minimal Depression")
    elif(score in range(5,10)):
        print("Mild Depression")
    elif(score in range(10,15)):
        print("Moderate Depression")
    elif(score in range(15,20)):
        print("Moderately Severe Depression")
    elif(score in range(20,28)):
        print("Severe Depression")
    else:
        print("No Depression")
    print("\033[0m")
        
        
def test(bodyStats, score):
    for i in range(len(bodyStats)):
        print("\n" ,i+1,". \033[1;34m", bodyStats[i], "\033[1;37m")
        print_options()
        score += accept_ans()
        # print("score= ", score)
    find_results(score)

test(bodyStats=question_list, score=score)