import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { RedirectionComponent } from './components/redirection/redirection.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: ':id', component: RedirectionComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
