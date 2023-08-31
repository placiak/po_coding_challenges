function oddishOrEvenish(num) {
    let sum = 0;
    //convert to string
    const numStr = num.toString();
    //loop through string
    for (const element of numStr) {
        //convert back to int and sum
      sum += parseInt(element, 10);
    }
    return sum % 2 === 0 ? "Evenish" : "Oddish";
  }

  console.log(oddishOrEvenish(46)); //evenish
  console.log(oddishOrEvenish(733)); //oddish
  console.log(oddishOrEvenish(555)); //oddish