(ns say)

(def ones
  {0 "zero"
   1 "one"
   2 "two"
   3 "three"
   4 "four"
   5 "five"
   6 "six"
   7 "seven"
   8 "eight"
   9 "nine"})

(def teens
  { 0 "ten"
   1 "eleven"
   2 "twelve"
   3 "thriteen"
   4 "fourteen"
   5 "fifteen"
   6 "sixteen"
   7 "seventeen"
   8 "eightteen"
   9 "nineteen"
   })

(def tens
  {2 "twenty"
   3 "thirty"
   4 "forty"
   5 "fifty"
   6 "sixty"
   7 "seventy"
   8 "eighty"
   9 "ninety"})

(defn get-place [num place]
  (rem (quot num place) 10))

(defn say-tens [num]
  (let [tendig (get-place num 10)
        onedig (get-place num 1)]
  (cond
    (= tendig 0) (get ones onedig)
    (= tendig 1) (get teens onedig)
    :else (if (= onedig 0) (get tens tendig) (str (get tens tendig) "-" (get ones onedig)))
    )))

(defn end-num [num say]
  (if (= num 0) ""
      (str " " (say num))))

(defn say-hundreds [num]
  (let [hundreds (get-place num 100)
        tens (rem num 100)]
    (if (= hundreds 0)
      (say-tens tens)
      (str (get ones hundreds) " hundred" (end-num tens say-tens))
        )
    ))

(defn say-thousands [num]
  (let [thousands (quot num 1000)
        hundreds (rem num 1000)]
    (if (= thousands 0)
      (say-hundreds hundreds)
      (str (say-hundreds thousands) " thousand" (end-num hundreds say-hundreds))
        )
    ))

(defn say-millions [num]
  (let [millions (quot num 1000000)
        thousands (rem num 1000000)]
    (if (= millions 0)
      (say-thousands thousands)
      (str (say-hundreds millions) " million" (end-num thousands say-thousands))
        )
    ))

(defn say-billions [num]
  (let [billions (quot num 1000000000)
        millions (rem num 1000000000)]
    (if (= billions 0)
      (say-millions millions)
      (str (say-hundreds billions) " billion" (end-num millions say-millions))
        )
    ))

(defn number [num]
  (cond (> num 999999999999) (throw (IllegalArgumentException. "number is out of range"))
        (< num 0) (throw (IllegalArgumentException. "number is out of range"))
        :else (say-billions num))
)

