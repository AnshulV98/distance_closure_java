import java.util.HashMap;

/*
Utils
==========================
Utility functions for the Distance Closure package
"""

Methods:    'dist2prox',
           'prox2dist',
           'dict2matrix',
           'matrix2dict',
           'dict2sparse'
 */
public class Utils {



    public float[][] prox2dist(float[][] P){
       /*
    Transforms a matrix of non-negative ``[0,1]`` proximities P to distance weights in the ``[0,inf]`` interval:
    .. math::
        d = \\frac{1}{p} - 1
    Args:
        P (matrix): Proximity matrix
    Returns:
        D (matrix): Distance matrix

     */
       //TODO: Understand working and requirement
        return null;
    }

    public float[][] _prox2dist_sparse(float[][] A){
        //TODO: Undertstand working and requirement
        return null;
    }

    public float[][] _prox2dist_numpy(float[][] A){
        //TODO: Understand working and requirement
        return null;
    }

    public float _prox2dist(float x){
        //TODO: Verify if this is correct
        if(x == 0)
            return Float.POSITIVE_INFINITY;
        else
            return (1/x)-1;
    }

    /*----------------------------------------------------------------------------------------------------------------------------------------------------------------*/

    public float[][] dist2prox(float[][] D){
        /*
             Transforms a matrix of non-negative integer distances ``D`` to proximity/similarity weights in the ``[0,1]`` interval:
    .. math::
        p = \\frac{1}{(d+1)}
    It accepts both dense and sparse matrices.
    Args:
        D (matrix): Distance matrix
    Returns:
        P (matrix): Proximity matrix
    See Also:
        :attr:`prox2dist`

         */
        //TODO: Understand requirement and implement
        return null;
    }

    public float[][] _dist2prox_sparse(float[][] A){
        //TODO: Understand requirement and implement
        return null;
    }

    public float[][] _dist2prox_numpy(float[][] A){
        //TODO: Understand requirement and implement
        return null;
    }

    public float _dist2prox(float x){
        //TODO: Verify if this is correct
        if(x==Float.POSITIVE_INFINITY)
            return 0;
        else
            return (float)Math.pow(x+1,-1);
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------//

    public float[][] dict2matrix(HashMap<Float,Float> dict){
        /*
        """
    Tranforms a 2D dictionary into a numpy. Usefull when converting Dijkstra results.
    Args:
        d (dict): 2D dictionary
    Returns:
        m (matrix): numpy matrix
    Warning:
        If your nodes have names instead of number assigned to them, make sure to keep a mapping.
    Usage:
        >>> d = {0: {0: 0, 1: 1, 2:3}, 1: {0: 1, 1: 0, 2:2}, 2: {0: 3, 1:2, 2:0}}
        >>> dict2matrix(d)
        [[ 0 1 3]
         [ 1 0 2]
         [ 3 2 0]]
    See Also:
        :attr:`matrix2dict`
         */

        //TODO: Understand requirement and implement
        return null;
    }

    public HashMap<Float, Float> matrix2dict(float[][] mat){
        /*
        Tranforms a Numpy matrix into a 2D dictionary. Usefull when comparing dense metric and Dijkstra results.
    Args:
        m (matrix): numpy matrix
    Returns:
        d (dict): 2D dictionary
    Usage:
        >>> m = [[0, 1, 3], [1, 0, 2], [3, 2, 0]]
        >>> matrix2dict(m)
        {0: {0: 0, 1: 1, 2:3}, 1: {0: 1, 1: 0, 2:2}, 2: {0: 3, 1:2, 2:0}}
    See Also:
        :attr:`dict2matrix`
         */

        //TODO: Understand requirements and implement

        return null;
    }

    public float[][] dict2sparse(HashMap<Float, Float> dict){
        /*
        Tranforms a 2D dictionary into a Scipy sparse matrix.
    Args:
        d (dict): 2D dictionary
    Returns:
        m (csr matrix): CRS Sparse Matrix
    Usage:
        >>> d = {0: {0: 0, 1: 1, 2:3}, 1: {0: 1, 1: 0, 2:2}, 2: {0: 3, 1:2, 2:0}}
        >>> dict2sparse(d)
        (0, 1)    1
        (0, 2)    3
        (1, 0)    1
        (1, 2)    2
        (2, 0)    3
        (2, 1)    2
    See Also:
        :attr:`dict2matrix`, :attr:`matrix2dict`
         */

        //TODO: Understand requirements and implement

        return null;
    }



}
