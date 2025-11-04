(ns nth-prime)

(defn prime? [p]
  (or
  (= p 2)
  (not (or (even? p)
  (some zero? (map #(rem p %) (range 3 (+ 1 (Math/sqrt p)) 2)))))))

(defn next-prime [p]
  (if (prime? (+ 2 p)) (+ 2 p) (recur (+ 2 p))))


(defn nth-prime
  "Returns the prime number in the nth position."
  [n]
  (case n
    0 (throw (IllegalArgumentException. "there is no zeroth prime"))
    1 2
    2 3
    (nth (iterate next-prime 3) (- n 2))
    ))

