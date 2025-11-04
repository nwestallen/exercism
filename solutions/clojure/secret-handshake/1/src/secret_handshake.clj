(ns secret-handshake)

(def actions '("reverse" "jump" "close your eyes" "double blink" "wink"))

(defn maskfilter [p c]
  (keep-indexed (fn [idx itm] (when (nth p idx) itm)) c))

(defn commands [n]
  (let [s (Long/toString n 2)
        b (str (apply str (repeat (- 5 (count s)) 0)) s)
        a (maskfilter (keep #(= % \1) b) actions)]
    (into [] (if (= (first a) "reverse") (rest a) (reverse a)))
    ))


