(ns hangman.core)

(def max-number-lifes 6)

(defn lost [] (print "You were hang!"))
(defn won [] (print "Congrats, you discovered the word!"))

(defn missing-letters [word guesses]
  (remove (fn [letter] (contains? guesses (str letter))) word)
  )

(defn guessed-word? [word guesses]
  (empty? (missing-letters word guesses))
  )

(defn game [lifes word guesses] (
                    (if (= lifes 0)
                      (lost)
                      (if (guessed-word? word guesses)
                        (won)
                        (print "Try another letter")
                        )
                      )
                    )
  )