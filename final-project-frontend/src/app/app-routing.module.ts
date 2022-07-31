import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { BannerComponent } from './components/banner/banner.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { RetrieveBooksComponent } from './components/retrieve-books/retrieve-books.component';
import { SearcherComponent } from './components/searcher/searcher.component';

const routes: Routes = [
  {
    path:"",
    component: HomeComponent
  },
  {
    path:"login",
    component: LoginComponent
  },
  {
    path:"register",
    component: RegisterComponent
  },
  {
    path:"searcher",
    component: SearcherComponent
  },
  {
    path:"retrieveBooks",
    component: RetrieveBooksComponent
  },
  {
    path:"banner",
    component: BannerComponent
  }
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
