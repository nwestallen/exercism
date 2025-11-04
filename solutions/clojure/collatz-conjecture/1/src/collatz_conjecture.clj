(ns collatz-conjecture)

(defn collatz
  ([num]
   (if (= num 1) 0 (collatz num 0)))
  ([num steps]
   (if (= num 1)
     steps
     (if (even? num) (collatz (/ num 2) (inc steps)) (collatz (inc (* num 3)) (inc steps)))))
)
