(ns pig-latin
  (:require [clojure.string :as str]))

(def vowels #{\a \e \i \o \u})

(def consonants #{\b \c \d \f \g \h \j \k \l \m \n \p \q \r \s \t \v \w \x \y \z})

(defn translate [word] (str/join " " (map (fn [word]
  (let
   [start (apply str (drop-while #(contains? consonants %) word))
    end (apply str (take-while #(contains? consonants %) word))]
    (cond (and (= (last end) \q) (= (first start) \u)) (str (apply str (rest start)) end "uay")
          (= (apply str (take 2 word)) "xr") (str word "ay")
          (= (apply str (take 2 word)) "yt") (str word "ay")
          (not-any? #(contains? vowels %) word) (str
                                                 (apply str (drop-while #(not= \y %) word))
                                                 (apply str (take-while #(not= \y %) word))
                                                 "ay")
          :else (str start end "ay")))) (str/split word #" "))))
