import React from 'react';
import { useParams } from 'react-router-dom';

const ParamsComponent = (props)=>{
    const {word, color, backgrCol} = useParams();
    return(
        <div>
            {
                isNaN(word)?
                <p style={
                    color? {color: color, backgroundColor:backgrCol}:null
                }>
                    The word is: {word}
                </p>
                :
                <p>
                    This number is: {word}
                </p>
            }
        </div>
    )
}


export default ParamsComponent;