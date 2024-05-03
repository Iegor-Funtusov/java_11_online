var x = 10;
x = "Hello";

x = () => {
    return ""
}

function fn(some) {
    console.log(some)
}

function fn1(some) {
    return fn(some)
}

function fn2(some) {
    fn1(some)
}

x = fn2(fn1("some"))


