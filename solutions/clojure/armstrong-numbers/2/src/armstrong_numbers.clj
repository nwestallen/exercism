(ns armstrong-numbers)

(defn armstrong?
  "Takes a number and determines whehter the sum of its digits raised to the power
  of the count of its digits is equal to itself"
  [num]
  (let [digits (map #(Character/getNumericValue %) (str num)) x (count digits)]
  (== (reduce + (map #(.pow (biginteger %) x) digits)) num))
)
