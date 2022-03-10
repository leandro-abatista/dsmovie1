import { ReactComponent as GitHubIcon } from 'assets/img/github.svg';
import './styles.css';

function NavBar() {

    return (
        /**navbar do projeto */
        <header>
            <nav className='container'>
                <div className='dsmovie-nav-content'>
                    <h1>DSMovie1</h1>

                    <a href="https://github.com/lheanndroaluno/dsmovie1">
                        <div className='dsmovie-contact-container'>
                            <GitHubIcon />
                            <p className='dsmovie-contact-link'>/GitHub - LeandroAmorim</p>
                        </div>
                    </a>
                </div>
            </nav>
        </header>
    );
}

export default NavBar;