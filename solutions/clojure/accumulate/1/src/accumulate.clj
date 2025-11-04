(ns accumulate)

(defn accumulate [func lst]
  (if (empty? lst)
    lst
    (cons (func (first lst)) (accumulate func (rest lst))))
  )
