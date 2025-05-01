print('hello, world!')
print('hello, hello, hello')

a = 10
print(a)

# 한 줄 주석

"""
여러줄 주석"""
'''
여러줄 주석'''

a = '''
여러줄 주석'''
print(a)

b = None
print(b)

a = 10
# a > 9 && a < 20
b = 9 < a < 20
print(b)

# print(5/0)
print(5 / 2)
print(5 // 3)
print( "-" * 20)

a = 10
# a++ >> 없음
# --a >> 그냥 a * -1 * -1 = 양수 10

print(str(a)+ 'a')

a = 5
b = 10
if a > b :
    print("a > b")
elif a == b :
    print("a와 b가 같다")
else :
    pass

for i in range(0, 10) :
    print(i)

def test() :
    global a

    print(a)
    a= 200

test()
print('a', a)