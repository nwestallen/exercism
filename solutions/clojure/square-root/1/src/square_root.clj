(ns square-root)

(defn square-root
  "Calculates the square root of a number using a version of Heron's method."
  [num]
  (let [ε 0.01]
    (loop [est (/ num 2)]
      (if (< (abs (- num (* est est))) ε)
        (int est)
        (recur (/ (+ est (/ num est)) 2)))
    )
    )
  )

