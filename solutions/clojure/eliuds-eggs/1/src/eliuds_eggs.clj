(ns eliuds-eggs)

(defn log2 [n]
  (/ (Math/log n) (Math/log 2)))

(defn egg-count
  "Returns the number of 1 bits in the binary representation of the given number."
  [num]
  (loop [n num res 0]
    (cond
      (== n 0) res
      (== n 1) (+ res 1)
      :else (let [l (log2 n)
                  r (- n (Math/pow 2 (quot l 1)))]
              (recur r (+ res 1))))))

