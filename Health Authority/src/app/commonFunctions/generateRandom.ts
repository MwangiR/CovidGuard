//exporting the permision code generate functions
export function generateRandomNumber() { 
    const U = f=> f (f)
    const Y = U (h=> f=> f (x=> h (h) (f) (x)))
    const comp = f=> g=> x=> f (g (x))
    const foldk = Y (h=> f=> y=> ([x, ...xs])=>
    x === undefined ? y : f (y) (x) (y=> h (f) (y) (xs)))
    const fold = f=> foldk (y=> x=> k=> k (f (y) (x)))
    const map = f=> fold (y=> x=> [...y, f (x)]) ([])
    const char = x=> String.fromCharCode(x)
    const concat = x=> y=> y.concat(x)
    const concatMap = f=> comp (fold (concat) ([])) (map (f))
    const irand = x=> Math.floor(Math.random() * x)
    const sample = xs=> xs [irand (xs.length)]

    const range = Y (f=> r=> x=> y=>
        x > y ? r : f ([...r, x]) (x+1) (y)
    ) ([])
    
    // srand : make random string from list or ascii code ranges
    // [(Range a)] -> Number -> [a]
    const srand = comp (Y (f=> z=> rs=> x=>
        x === 0 ? z : f (z + sample (rs)) (rs) (x-1)
    ) ([])) (concatMap (map (char)))

    const idGenerator = srand ([
        range (48) (57),  // include 0-9
        range (65) (90),  // include A-Z
        range (97) (122)  // include a-z
    ])    
    return idGenerator(10);
}