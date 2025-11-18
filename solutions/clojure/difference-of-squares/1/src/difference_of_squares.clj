(ns difference-of-squares)

(defn square [n]
  (* n n))

(defn square-of-sum
  "Returns the square of the sum of the numbers up to N."
  [N]
  (square (apply + (range 1 (+ N 1))))
  )

(defn sum-of-squares
  "Returns the sum of the squares of the numbers up to N."
  [N]
  (apply + (map square (range 1 (+ N 1))))
  )

(defn difference
  "Returns the difference between the square of the sum
  and the sum of the squares of the numbers up to N."
  [N]
  (- (square-of-sum N) (sum-of-squares N))
  )

