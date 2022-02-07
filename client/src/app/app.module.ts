import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppComponent } from './app.component';

import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';


import { LogInPageComponent } from './log-in-page/log-in-page.component';
import { SignUpPageComponent } from './sign-up-page/sign-up-page.component';
import { ForgotPswdPageComponent } from './forgot-pswd-page/forgot-pswd-page.component';
import { ProfileComponent } from './profile/profile.component';
import { NavbarComponent } from './navbar/navbar.component';
import { EventComponent } from './event/event.component';
import { HomeComponent } from './home/home.component';
import { ChatComponent } from './chat/chat.component';
import { MeetUpFormComponent } from './meet-up-form/meet-up-form.component';
import { MeetUpDisplayComponent } from './meet-up-display/meet-up-display.component';
import { HostedMatchesComponent } from './hosted-matches/hosted-matches.component';
import { LocatedMeetUpDisplayComponent } from './located-meet-up-display/located-meet-up-display.component';
@NgModule({
  declarations: [
    AppComponent,
    LogInPageComponent,
    SignUpPageComponent,
    ForgotPswdPageComponent,
    ProfileComponent,
    NavbarComponent,
    EventComponent,
    HomeComponent,
    ChatComponent,
    MeetUpFormComponent,
    MeetUpDisplayComponent,
    HostedMatchesComponent,
    LocatedMeetUpDisplayComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
