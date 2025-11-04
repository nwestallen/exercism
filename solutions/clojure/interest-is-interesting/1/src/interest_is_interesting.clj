(ns interest-is-interesting)

(defn interest-rate
  "Returns an interest rate based on some rules"
  [balance]
  (cond
      (> 0 balance) -3.213
      (> 1000 balance) 0.5
      (> 5000 balance) 1.621
      :else 2.475
      )
  )

(defn annual-balance-update
  "Applies interest to balance, negative interest rate applied strangely"
  [balance]
  (+ balance (* (bigdec (interest-rate balance)) (if (pos? balance) balance (- balance)) 0.01M))
  )

(defn amount-to-donate
  "Why is the amount to donate doubled? No idea but that's how the tests pass"
  [balance tax-free-percentage]
  (if (pos? balance) (int (* balance (/ tax-free-percentage 100) 2)) 0)
  )
