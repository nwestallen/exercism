(ns roman-numerals)

(def units {1 "I" 2 "II" 3 "III" 4 "IV" 5 "V" 6 "VI" 7 "VII" 8 "VIII" 9 "IX"})

(def tens {1 "X" 2 "XX" 3 "XXX" 4 "XL" 5 "L" 6 "LX" 7 "LXX" 8 "LXXX" 9 "XC"})

(def hundreds {1 "C" 2 "CC" 3 "CCC" 4 "CD" 5 "D" 6 "DC" 7 "DCC" 8 "DCCC" 9 "CM"})

(defn numerals [num]
  (str
   (apply str (repeat (quot num 1000) "M"))
   (get hundreds (quot (rem num 1000) 100))
   (get tens (quot (rem num 100) 10))
   (get units (rem num 10))
   )
)
