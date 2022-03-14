import axios from "axios";
import MovieCard from "components/MovieCard";
import Pagination from "components/Pagination";
import { useEffect, useState } from "react";
import { MoviePage } from "types/movie";
import { BASE_URL } from "utils/requests";

function Listing() {

    const [pageNumber, setPageNumber] = useState(0);

    const [page, setPage] = useState<MoviePage>({
        content: [],
        last: true,
        totalPages: 0,
        totalElements: 0,
        size: 10,
        number: 0,
        first: true,
        numberOfElements: 0,
        empty: true
    });

    useEffect(() => {
        axios.get(`${BASE_URL}/movies?size=10&page=${pageNumber}&sort=id`)
            .then(response => {
                //console.log(response.data);

                /**DADOS DA RESPOSTA */
                const data = response.data as MoviePage;
                //console.log(response.data);
                setPage(data);

                /** COLOCA DENTRO DA PÁGINANUMBER */
                //setPageNumber(data.number);
            });
    }, [pageNumber]);

    return (
        <>
            <p>{pageNumber}</p>
            <Pagination />

            <div className="container">
                <div className="row">

                    {page.content.map(item => (
                        <div key={item.id} className="col-sm-6 col-lg-4 col-xl-3 mb-3">
                            <MovieCard movie={item} />
                        </div>
                    )

                    )}
                </div>
            </div>
        </>
    );
}

export default Listing;