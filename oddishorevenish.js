function oddishOrEvenish(num) {
    let sum = 0;
    const numStr = num.toString();
    for (const digit of numStr) {
      sum += parseInt(digit, 10);
    }
    return sum % 2 === 0 ? "Evenish" : "Oddish";
  }

  console.log(oddishOrEvenish(46)); //evenish
  console.log(oddishOrEvenish(733)); //oddish
  console.log(oddishOrEvenish(555)); //oddish