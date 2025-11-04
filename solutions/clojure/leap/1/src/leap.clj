(ns leap)

(defn leap-year?
  "Determine if a year is a leap year"
  [year]
  (if (= 0 (mod year 400))
    true
    (if (= 0 (mod year 100))
      false
      (= 0 (mod year 4))))
  )
