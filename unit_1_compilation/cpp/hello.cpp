#include <iostream>
#include <string.h>

int main()
{
    int a = 10;
    std::cout << a << '\n';
    std::cout << &a << '\n';
    std::cout << *&a << '\n';

    return 0;
}

struct Student
{
    int age;
    string name;
    int ptrAge = &setAge;
}

Student s = malloc();
s.ptrAge(10);

void setAge(int age)
{

}