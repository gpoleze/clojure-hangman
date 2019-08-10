(ns hangman.core)

(def max-number-lifes 6)

(defn gameover [] (print "You were hang!"))

(defn game [lifes] (
                    (if (= lifes 0)
                      (gameover)
                      (do
                        (print lifes)
                        (game (dec lifes))
                        )
                      )
                    )
  )


(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))
