(ns darts)

(defn score
  "Calculates the score of a dart throw."
  [x y]
  ;; function body
  (let [dist (+ (* x x) (* y y))]
    (cond
      (<= dist 1) 10
      (<= dist 25) 5
      (<= dist 100) 1
      :else 0)
    )
  )
