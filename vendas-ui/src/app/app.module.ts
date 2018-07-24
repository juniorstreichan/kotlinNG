import { BrowserModule } from "@angular/platform-browser";
import { BrowserAnimationsModule } from "@angular/platform-browser/animations";
import { NgModule, LOCALE_ID } from "@angular/core";

import { MessageService } from "primeng/components/common/messageservice";
import { TableModule } from "primeng/table";
import { DropdownModule } from "primeng/dropdown";
import { InputTextModule } from "primeng/inputtext";
import { PanelModule } from "primeng/panel";
import { ButtonModule } from "primeng/button";
import { GrowlModule } from "primeng/growl";

import { HttpClientModule } from "@angular/common/http";
import { AppComponent } from "./app.component";
import { NavbarComponent } from "./components/navbar/navbar.component";
import { VendasListagemComponent } from "./components/vendas-listagem/vendas-listagem.component";
import localePt from "@angular/common/locales/pt";
import { CurrencyMaskModule } from "ng2-currency-mask";
import { registerLocaleData } from "@angular/common";
import { VendaCadastroComponent } from "./components/venda-cadastro/venda-cadastro.component";
import { FormsModule } from "@angular/forms";

registerLocaleData(localePt);
@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    VendasListagemComponent,
    VendaCadastroComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    CurrencyMaskModule,
    TableModule,

    HttpClientModule,
    DropdownModule,
    InputTextModule,
    FormsModule,
    PanelModule,
    ButtonModule,
    GrowlModule
  ],
  providers: [{ provide: LOCALE_ID, useValue: "pt" }, MessageService],
  bootstrap: [AppComponent]
})
export class AppModule {}
