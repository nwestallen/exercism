(ns cars-assemble)

(defn production-rate
  "Returns the assembly line's production rate per hour,
   taking into account its success rate"
  [speed]
  (let [output (* 221 speed)]
    (cond
      (> 5 speed) (* 1.0 output)
      (> 9 speed) (* 0.9 output)
      (= 9 speed) (* 0.8 output)
      :else (* 0.77 output)
      )
    )
  )

(defn working-items
  "Calculates how many working cars are produced per minute"
  [speed]
  (int (/ (production-rate speed) 60))
  )
